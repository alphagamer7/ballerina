/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.bre.bvm;

import org.ballerinalang.model.values.BRefType;
import org.ballerinalang.util.codegen.CallableUnitInfo;
import org.ballerinalang.util.codegen.CodeAttributeInfo;
import org.ballerinalang.util.codegen.PackageInfo;

/**
 * @since 0.87
 */
public class StackFrame {
    long[] longLocalVars;
    double[] doubleLocalVars;
    String[] stringLocalVars;
    // These are used for array indexes and boolean values;
    int[] intLocalVars;
    BRefType[] refLocalVars;

    long[] longRegs;
    double[] doubleRegs;
    String[] stringRegs;
    int[] intRegs;
    BRefType[] refRegs;

    // Return address of the caller
    int retAddrs;

    // Caller's Register indexes to which the return values should be copied;
    int[] retRegIndexes;

    CallableUnitInfo callableUnitInfo;

    PackageInfo packageInfo;

    public StackFrame(int retAddrs, int[] retRegIndexes) {
        this.retAddrs = retAddrs;
        this.retRegIndexes = retRegIndexes;
    }

    public StackFrame(CallableUnitInfo callableUnitInfo, int retAddrs, int[] retRegIndexes) {
        this.callableUnitInfo = callableUnitInfo;
        this.packageInfo = callableUnitInfo.getPackageInfo();
        CodeAttributeInfo codeAttribInfo = callableUnitInfo.getCodeAttributeInfo();

        this.longLocalVars = new long[codeAttribInfo.getMaxLongLocalVars()];
        this.doubleLocalVars = new double[codeAttribInfo.getMaxDoubleLocalVars()];

        this.stringLocalVars = new String[codeAttribInfo.getMaxStringLocalVars()];
        // Setting the zero values for strings
        for (int i = 0; i < stringLocalVars.length; i++) {
            this.stringLocalVars[i] = "";
        }

        this.intLocalVars = new int[codeAttribInfo.getMaxIntLocalVars()];
        this.refLocalVars = new BRefType[codeAttribInfo.getMaxRefLocalVars()];

        this.longRegs = new long[codeAttribInfo.getMaxLongRegs()];
        this.doubleRegs = new double[codeAttribInfo.getMaxDoubleRegs()];
        this.stringRegs = new String[codeAttribInfo.getMaxStringRegs()];
        this.intRegs = new int[codeAttribInfo.getMaxIntRegs()];
        this.refRegs = new BRefType[codeAttribInfo.getMaxRefRegs()];

        this.retAddrs = retAddrs;
        this.retRegIndexes = retRegIndexes;
    }

    public long[] getLongRegs() {
        return longRegs;
    }

    public double[] getDoubleRegs() {
        return doubleRegs;
    }

    public String[] getStringRegs() {
        return stringRegs;
    }

    public int[] getIntRegs() {
        return intRegs;
    }

    public BRefType[] getRefRegs() {
        return refRegs;
    }

    public void setLongLocalVars(long[] longLocalVars) {
        this.longLocalVars = longLocalVars;
    }

    public void setDoubleLocalVars(double[] doubleLocalVars) {
        this.doubleLocalVars = doubleLocalVars;
    }

    public void setStringLocalVars(String[] stringLocalVars) {
        this.stringLocalVars = stringLocalVars;
    }

    public void setIntLocalVars(int[] intLocalVars) {
        this.intLocalVars = intLocalVars;
    }

    public void setRefLocalVars(BRefType[] refLocalVars) {
        this.refLocalVars = refLocalVars;
    }

    public void setLongRegs(long[] longRegs) {
        this.longRegs = longRegs;
    }

    public void setDoubleRegs(double[] doubleRegs) {
        this.doubleRegs = doubleRegs;
    }

    public void setStringRegs(String[] stringRegs) {
        this.stringRegs = stringRegs;
    }

    public void setIntRegs(int[] intRegs) {
        this.intRegs = intRegs;
    }

    public void setRefRegs(BRefType[] refRegs) {
        this.refRegs = refRegs;
    }
}