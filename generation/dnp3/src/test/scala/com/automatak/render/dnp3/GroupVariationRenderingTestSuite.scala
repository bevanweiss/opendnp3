/*
 * Copyright 2013-2020 Automatak, LLC
 *
 * Licensed to Green Energy Corp (www.greenenergycorp.com) and Automatak
 * LLC (www.automatak.com) under one or more contributor license agreements. 
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Green Energy Corp and Automatak LLC license
 * this file to you under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may obtain
 * a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.automatak.render.dnp3

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, FunSuite}

import com.automatak.render.dnp3.objects.ObjectGroup
import com.automatak.render.dnp3.objects.generators._
import com.automatak.render.cpp.CppIndentation


@RunWith(classOf[JUnitRunner])
class GroupVariationRenderingTestSuite extends FunSuite with Matchers {

  test("Experiment with rendering") {

      implicit val indentation = CppIndentation()

      for {
        g <- ObjectGroup.all
        v <- g.objects
      } GroupVariationImplRenderer.render(v).foreach(println)
  }



}
