<@compress single_line=true>
<#if tablePart.columnDeclaration>
  <#assign columnDeclaration=tablePart/><#include "/columns/_columnDeclaration.ftl">
<#else>
  <#assign constraintDeclaration=tablePart/><#include "/constraints/_constraintDeclaration.ftl">
</#if>
</@compress>
