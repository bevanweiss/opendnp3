package com.automatak.render.dnp3.enums.groups

import com.automatak.render.dnp3.enums._
import com.automatak.render.dnp3.EnumConfig


object DNPCppEnumGroup {

  def enums : List[EnumConfig] = List(fullEnums, simpleEnums, stringOnlyEnums).flatten

  private def fullEnums = List(
    FunctionCode(),
    QualifierCode(),
    LinkFunction(),
    IntervalUnit(),
    ControlCode(),
    GroupVariationEnum(),
    DoubleBit(),
    CommandStatus(),
    HMACType(),
    ChallengeReason(),
    KeyWrapAlgorithm(),
    KeyStatus(),
    AuthErrorCode(),
    CertificateType(),
    KeyChangeMethod(),
    UserOperation(),
    UserRole()
  ).map(x => EnumConfig(x, true, true))

  private def simpleEnums = (List(
    AssignClassType(),
    StaticTypeBitmask(),
    PointClass(),
    TimeSyncMode(),
    RestartMode(),
    TimestampMode(),
    EventMode(),
    IndexMode(),
    ConfigAuthMode(),
    SecurityStatIndex(),
    RestartType()
  ) ::: DefaultVariations.enums ::: QualityMasks.enums).map(x => EnumConfig(x, false, false))

  private def stringOnlyEnums = List(
    MasterTaskType(),
    TaskCompletion(),
    ChannelState(),
    LinkStatus(),
    CommandPointState()).map(x => EnumConfig(x, false, true))

}