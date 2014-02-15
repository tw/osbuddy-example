package com.osbuddy.example.override;

import com.osbuddy.api.APIModule;
import com.osbuddy.api.Walking;

/**
 * @author rvbiljouw
 */
public class CustomAPIModule extends APIModule {

    @Override
    public Class checkBinding(java.lang.Class bindable, java.lang.Class standard) {
        if(bindable == Walking.class) {
            return AlternativeWalking.class;
        }
        return standard;
    }


}
