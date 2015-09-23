<#include "/macros/_renderAsModel.ftl" />
<#if model.identification??><#include "/constraints/_constraintIdentification.ftl"/>${" "}</#if><@renderAsModel model=model.definition/>