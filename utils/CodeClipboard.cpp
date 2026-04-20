#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <windows.h>
#include <cstring>

// ===================== 核心配置 =====================
// 工具放在 【项目根目录】
#define BASE_PATH "../src/main/java/com/xm/acwing/improve"
#define FILE_PREFIX "Main"
#define FILE_SUFFIX ".java"
// ====================================================

// 递归搜索文件
bool searchFile(const std::string& folder, const std::string& targetName, std::string& outPath) {
    WIN32_FIND_DATA findData;
    HANDLE hFind = INVALID_HANDLE_VALUE;
    std::string searchPath = folder + "\\*.*";

    hFind = FindFirstFile(searchPath.c_str(), &findData);
    if (hFind == INVALID_HANDLE_VALUE) return false;

    do {
        std::string fileName = findData.cFileName;
        if (fileName == "." || fileName == "..") continue;

        std::string fullPath = folder + "\\" + fileName;
        if (findData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY) {
            if (searchFile(fullPath, targetName, outPath)) {
                FindClose(hFind);
                return true;
            }
        } else {
            if (fileName == targetName) {
                outPath = fullPath;
                FindClose(hFind);
                return true;
            }
        }
    } while (FindNextFile(hFind, &findData));

    FindClose(hFind);
    return false;
}

// 读取文件内容
bool readFile(const std::string& path, std::string& content) {
    std::ifstream file(path.c_str(), std::ios::binary);
    if (!file.is_open()) return false;
    content.assign((std::istreambuf_iterator<char>(file)), std::istreambuf_iterator<char>());
    file.close();
    return true;
}

// 处理Java代码：删包名、删题目注释、改类名
void processJavaCode(std::string& content, const std::string& num) {
    std::vector<std::string> lines;
    std::string line;

    // 按行分割
    for (int i = 0; i < content.size(); ++i) {
        char c = content[i];
        if (c == '\n') {
            lines.push_back(line);
            line.clear();
        } else {
            line += c;
        }
    }
    if (!line.empty()) lines.push_back(line);

    content.clear();
    std::string oldClass = "public class " + std::string(FILE_PREFIX) + num;
    std::string newClass = "public class Main";
    bool inComment = false;

    // 逐行处理 ✅修复注释匹配逻辑
    for (int i = 0; i < lines.size(); ++i) {
        std::string& l = lines[i];
        std::string trimLine = l;
        trimLine.erase(0, trimLine.find_first_not_of(" \t"));
        trimLine.erase(trimLine.find_last_not_of(" \t") + 1);

        // 1. 删除package包名行
        if (trimLine.find("package") == 0) continue;

        // 2. ✅修复：匹配 以/**开头 的注释（支持带文字的注释）
        if (trimLine.find("/**") == 0) {
            inComment = true;
            continue;
        }
        // 匹配注释块内所有内容 + 以*/结尾的结束行
        if (inComment) {
            if (trimLine.rfind("*/") == trimLine.length() - 2) {
                inComment = false;
            }
            continue;
        }

        // 3. 替换类名 MainXXX -> Main
        size_t pos = l.find(oldClass);
        if (pos != std::string::npos) l.replace(pos, oldClass.length(), newClass);

        content += l + "\r\n";
    }
}

// 复制到Windows剪贴板
bool copyToClipboard(const std::string& text) {
    if (!OpenClipboard(NULL)) return false;
    EmptyClipboard();
    HGLOBAL hMem = GlobalAlloc(GMEM_MOVEABLE, text.length() + 1);
    if (!hMem) { CloseClipboard(); return false; }
    char* pMem = (char*)GlobalLock(hMem);
    strcpy(pMem, text.c_str());
    GlobalUnlock(hMem);
    SetClipboardData(CF_TEXT, hMem);
    CloseClipboard();
    return true;
}

// 处理单个题目
void handleQuestion(const std::string& num) {
    std::string targetFile = FILE_PREFIX + num + FILE_SUFFIX;
    std::string filePath;

    std::cout << "\n正在搜索文件：" << targetFile << " ..." << std::endl;

    if (!searchFile(BASE_PATH, targetFile, filePath)) {
        std::cout << "❌ 未找到文件：" << targetFile << std::endl;
        return;
    }
    std::cout << "✅ 找到文件：" << filePath << std::endl;

    std::string content;
    if (!readFile(filePath, content)) {
        std::cout << "❌ 读取文件失败" << std::endl;
        return;
    }

    processJavaCode(content, num);

    if (copyToClipboard(content)) {
        std::cout << "✅ 处理完成！代码已复制到剪贴板（注释/包名已删除）" << std::endl;
    } else {
        std::cout << "❌ 复制剪贴板失败" << std::endl;
    }
}

int main() {
    SetConsoleOutputCP(CP_UTF8);
    std::string input;

    std::cout << "===== Acwing OJ 代码处理工具 =====" << std::endl;
    std::cout << "输入数字处理，输入 q 退出\n" << std::endl;

    // 无限循环
    while (true) {
        std::cout << "请输入题目数字：";
        std::cin >> input;

        if (input == "q" || input == "Q") {
            std::cout << "程序退出！" << std::endl;
            break;
        }

        handleQuestion(input);
    }

    return 0;
}