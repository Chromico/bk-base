/*
 * Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-BASE 蓝鲸基础平台 is licensed under the MIT License.
 *
 * License for BK-BASE 蓝鲸基础平台:
 * --------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.base.datalab.queryengine.validator.optimizer;

import com.tencent.bk.base.datalab.bksql.util.DeParsingMatcher;
import com.tencent.bk.base.datalab.bksql.validator.OptimizerTestSupport;
import java.util.Arrays;
import org.junit.Test;

public class DruidTheDatePartitionOptimizerTest extends OptimizerTestSupport {

    @Test
    public void testSql1() throws Exception {
        assertThat(
                Arrays.asList(new DruidTheDatePartitionOptimizer()),
                "SELECT col FROM tab WHERE thedate = '20080808'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE (__time >= '2008-08-07T16:00:00.000Z') AND "
                                + "(__time "
                                + "<= '2008-08-08T15:59:59.000Z')"));
    }

    @Test
    public void testSql2() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate != '20080808'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE (__time > '2008-08-08T15:59:59.000Z') OR "
                                + "(__time < "
                                + "'2008-08-07T16:00:00.000Z')"));
    }

    @Test
    public void testSql3() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate > '20191121'",
                new DeParsingMatcher("SELECT col FROM tab WHERE __time > '2019-11-21T15:59:59"
                        + ".000Z'"));
    }

    @Test
    public void testSql4() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate >= '20191121'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE __time >= '2019-11-20T16:00:00.000Z'"));
    }

    @Test
    public void testSql5() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate < '20191121'",
                new DeParsingMatcher("SELECT col FROM tab WHERE __time < '2019-11-20T16:00:00"
                        + ".000Z'"));
    }

    @Test
    public void testSql6() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate <= '20191121'",
                new DeParsingMatcher("SELECT col FROM tab WHERE __time <= '2019-11-21T15:59:59"
                        + ".000Z'"));
    }

    @Test
    public void testSql7() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab WHERE thedate between '20191121' and '20191125'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE (__time >= '2019-11-20T16:00:00.000Z') AND "
                                + "(__time "
                                + "<= '2019-11-25T15:59:59.000Z')"));
    }

    @Test
    public void testSql8() throws Exception {
        assertThat(
                new DruidTheDatePartitionOptimizer(),
                "SELECT col FROM tab a WHERE a.thedate = '20080808'",
                new DeParsingMatcher(
                        "SELECT col FROM tab AS a WHERE (a.__time >= '2008-08-07T16:00:00.000Z') "
                                + "AND "
                                + "(a.__time <= '2008-08-08T15:59:59.000Z')"));
    }
}