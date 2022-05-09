package constants;

import helpers.PropertiesHelpers;

//final -> We do not want any class to extend this class
public final class FrameworkConstants {
    //private -> We do not want anyone to create the object of this class
    private FrameworkConstants(){};

    public static final String BASE_URl = PropertiesHelpers.getValue("base_url"); //base_url lấy từ test/config
}
