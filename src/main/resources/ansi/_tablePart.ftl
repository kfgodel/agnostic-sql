<@compress single_line=true>
<#if tablePart.columnDeclaration>
  <#assign columnDeclaration=tablePart/><#include "_columnDeclaration.ftl">
<#else>
  <#assign tableConstraint=tablePart/><#include "_tableConstraint.ftl">
</#if>
</@compress>
