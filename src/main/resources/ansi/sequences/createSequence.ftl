<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
CREATE SEQUENCE <@renderAsModel model=model.sequence/>
  <#if model.usesStartValue>
  ${" START WITH "}${model.startingValue}
  </#if>
  <#if model.usesIncrementValue>
  ${" INCREMENT BY "}${model.incrementValue}
  </#if>
</@compress>