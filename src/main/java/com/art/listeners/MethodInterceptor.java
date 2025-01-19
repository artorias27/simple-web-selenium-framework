package com.art.listeners;

import com.art.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    private static final String columnExecute = "execute";
    private static final String columnTestcase = "testcaseName";
    private static final String columnCount = "count";
    private static final String columnDescription = "description";

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methodList, ITestContext iTestContext) {
        List<Map<String, String>> testcaseList = ExcelUtils.getTestcases();
        List<IMethodInstance> interceptedMethodList = new ArrayList<>();

        for (IMethodInstance iMethodInstance : methodList) {
            for (Map<String, String> testMap : testcaseList) {
                if (testMap.get(columnExecute).equalsIgnoreCase("yes")) {
                    if (iMethodInstance.getMethod().getMethodName().equalsIgnoreCase(testMap.get(columnTestcase))) {
                        iMethodInstance.getMethod().setInvocationCount(Integer.parseInt(testMap.get(columnCount)));
                        iMethodInstance.getMethod().setDescription(testMap.get(columnDescription));
                        interceptedMethodList.add(iMethodInstance);
                    }
                }
            }
        }
        return interceptedMethodList;
    }

//    @Override
//    public List<IMethodInstance> intercept(List<IMethodInstance> methodList, ITestContext iTestContext) {
//
//        List<Map<String, String>> testcaseList = ExcelUtils.getTestcases();
//        return methodList.stream()
//                .filter(method -> shouldExecute(method, testcaseList))
//                .peek(method -> updateMethodAttributes(method, testcaseList))
//                .collect(Collectors.toList());
//    }
//
//    private boolean shouldExecute(IMethodInstance methodInstance, List<Map<String, String>> testcaseList) {
//        return testcaseList.stream()
//                .anyMatch(testcase ->
//                        testcase.get(columnExecute).equalsIgnoreCase("yes") &&
//                                methodInstance.getMethod().getMethodName().equalsIgnoreCase(testcase.get(columnTestcase)));
//    }
//
//    private void updateMethodAttributes(IMethodInstance methodInstance, List<Map<String, String>> testcaseList) {
//        testcaseList.stream()
//                .filter(testcase ->
//                        testcase.get(columnExecute).equalsIgnoreCase("yes") &&
//                        methodInstance.getMethod().getMethodName().equalsIgnoreCase(testcase.get(columnTestcase)))
//                .findFirst()
//                .ifPresent(testcase -> {
//                    int invocationCount = Integer.parseInt(testcase.get(columnCount));
//                    methodInstance.getMethod().setInvocationCount(invocationCount);
//                    methodInstance.getMethod().setDescription(testcase.get(columnDescription));
//                });
//    }
}
