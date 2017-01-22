/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.cts.managedprofile;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.test.AndroidTestCase;

/**
 * Base class for profile-owner based tests.
 *
 * This class handles making sure that the test is the profile owner and that it has an active admin
 * registered, so that all tests may assume these are done.
 */
public class BaseManagedProfileTest extends AndroidTestCase {

    public static class BasicAdminReceiver extends DeviceAdminReceiver {
    }

    public static final ComponentName ADMIN_RECEIVER_COMPONENT = new ComponentName(
            BasicAdminReceiver.class.getPackage().getName(), BasicAdminReceiver.class.getName());

    protected DevicePolicyManager mDevicePolicyManager;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

       mDevicePolicyManager = (DevicePolicyManager)
               mContext.getSystemService(Context.DEVICE_POLICY_SERVICE);
       assertNotNull(mDevicePolicyManager);

       // TODO: Only check the below if we are running as the profile user. If running under the
       // user owner, can we check that there is a profile and that the below holds for it? If we
       // don't want to do these checks every time we could get rid of this class altogether and
       // just have a single test case running under the profile user that do them.
       assertTrue(mDevicePolicyManager.isAdminActive(ADMIN_RECEIVER_COMPONENT));
       assertTrue(mDevicePolicyManager.isProfileOwnerApp(
               ADMIN_RECEIVER_COMPONENT.getPackageName()));
    }
}
