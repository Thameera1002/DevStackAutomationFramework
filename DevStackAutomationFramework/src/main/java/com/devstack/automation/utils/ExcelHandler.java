package com.devstack.automation.utils;

import java.lang.reflect.Method;

public class ExcelHandler {
    private static final String EXCEL_PATH = "src/test/resources/excelData/";


    public static Object[][] commonDataProvider(Method method) {
        String testClassName = method.getDeclaringClass().getSimpleName();
        String testMethodName = method.getName();
        String excelFileName = testClassName+".xlsx";

        Class<?> modelClass = getModelClass(testClassName);


        return readExcelData(EXCEL_PATH+excelFileName,testMethodName,modelClass);
    }

    private static Object[][] readExcelData(String filePath, String sheetName, Class<?> modelClass) {
        
        return null;
    }

    private static Class<?> getModelClass(String testClassName) {
        String modelClassName = testClassName+"Data";
        try {
            return Class.forName("com.devstack.automation.model."+modelClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Model class not found for "+modelClassName,e);
        }
    }
}
