# -*- coding: utf-8 -*-
"""
Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.
Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
BK-BASE 蓝鲸基础平台 is licensed under the MIT License.
License for BK-BASE 蓝鲸基础平台:
--------------------------------------------------------------------
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
"""

from common.api.base import DataAPI
from datamanage.pizza_settings import META_API_ROOT
from datamanage.pizza_settings import DATAMANAGE_API_ROOT


class _MetaAPi(object):
    def __init__(self):
        self.retrieve_result_table = DataAPI(
            method='GET',
            url=META_API_ROOT + '/result_tables/{result_table_id}/',
            module='meta',
            url_keys=['result_table_id'],
            description='meta',
        )

        self.get_result_tables = DataAPI(
            method='GET',
            url=META_API_ROOT + '/result_tables/',
            module='meta',
            url_keys=['result_table_ids'],
            description='meta',
        )

        self.get_standard_detail = DataAPI(
            method='GET',
            url=DATAMANAGE_API_ROOT + '/dstan/standard/get_standard/',
            module='meta',
            description='standard',
        )

        self.complex_search = DataAPI(
            method='POST',
            url=META_API_ROOT + '/basic/entity/complex_search/',
            module='data_query',
            description='data_query',
        )

        self.get_bizs = DataAPI(
            method='GET', url=META_API_ROOT + '/bizs/', module='meta', url_keys=[], description='meta'
        )


MetaAPi = _MetaAPi()