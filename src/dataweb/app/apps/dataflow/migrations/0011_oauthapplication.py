# -*- coding: utf-8 -*-
"""
Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础计算平台 available.
Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://opensource.org/licenses/MIT
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
"""
# Generated by Django 1.11.2 on 2020-03-25 03:51


from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("dataflow", "0010_auto_20190814_1058"),
    ]

    operations = [
        migrations.CreateModel(
            name="OAuthApplication",
            fields=[
                ("id", models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name="ID")),
                ("bk_app_code", models.CharField(db_index=True, max_length=256, verbose_name="\u5e94\u7528ID")),
                ("bk_app_name", models.CharField(max_length=256, verbose_name="\u5e94\u7528\u540d\u79f0")),
                ("bk_app_logo", models.CharField(max_length=512, verbose_name="\u5e94\u7528\u540d\u79f0")),
                ("managers", models.CharField(max_length=256, verbose_name="\u5e94\u7528\u8d1f\u8d23\u4eba")),
                ("created_at", models.DateTimeField(auto_now_add=True, verbose_name="\u521b\u5efa\u65f6\u95f4")),
                ("updated_at", models.DateTimeField(auto_now=True, verbose_name="\u66f4\u65b0\u65f6\u95f4")),
            ],
            options={
                "verbose_name": "\u3010OAuth\u3011\u7b2c\u4e09\u65b9\u6388\u6743\u5e94\u7528",
                "verbose_name_plural": "\u3010OAuth\u3011\u7b2c\u4e09\u65b9\u6388\u6743\u5e94\u7528",
            },
        ),
    ]