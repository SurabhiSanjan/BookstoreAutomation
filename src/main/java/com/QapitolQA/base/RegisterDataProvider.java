package com.QapitolQA.base;

public class RegisterDataProvider {
    @org.testng.annotations.DataProvider(name = "data-provider")
    public static Object[][] getData() {
        return new Object[][]{
                {"Qail_--tA", "23o987h","auc@gai7l0.com", "qwerty", "qwerty"},
                {"Brigeiz_--gf", "687407769","xy@im9ail0.com",  "qwerty", "qwerty"},
                {"Goe_yu", "56689j8","pqur@gm9il0.com", "qwerty", "qwerty"}
        };
    }
}
