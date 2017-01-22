/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.graphics.cts;

import junit.framework.TestCase;
import android.graphics.Interpolator.Result;
import android.graphics.Shader.TileMode;


public class Interpolator_ResultTest extends TestCase {

    public void testValueOf() {
        assertEquals(Result.FREEZE_START, Result.valueOf("FREEZE_START"));
        assertEquals(Result.FREEZE_END, Result.valueOf("FREEZE_END"));
        assertEquals(Result.NORMAL, Result.valueOf("NORMAL"));
    }

    public void testValues() {
        Result[] result = Result.values();
        assertEquals(3, result.length);
        assertEquals(Result.NORMAL, result[0]);
        assertEquals(Result.FREEZE_START, result[1]);
        assertEquals(Result.FREEZE_END, result[2]);
    }
}