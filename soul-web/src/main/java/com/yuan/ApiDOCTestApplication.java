package com.yuan;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * api文档
 */
public class ApiDOCTestApplication {
    private static String projectPath = "E:\\IDEAproject_and_Giteeproject\\soul"; // 项目根目录
    private static String projectName = "soul"; // 项目名称
    private static String apiVersion = "V1"; //api版本
    private static String docsPath = "E:\\IDEAproject_and_Giteeproject\\soul_data\\api_doc"; // 生成API 文档所在地址

    /**
     * 生成api
     */
    public static void main(String[] args) {
        //api生成器
        DocsConfig config = new DocsConfig();
        config.setProjectPath(projectPath);
        config.setProjectName(projectName);
        config.setApiVersion(apiVersion);
        config.setDocsPath(docsPath);
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
