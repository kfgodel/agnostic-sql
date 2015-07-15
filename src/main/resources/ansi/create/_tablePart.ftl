<@compress single_line=true>
<#if tablePart.columnDeclaration>
  <#assign columnDeclaration=tablePart/><#include "/columns/_columnDeclaration.ftl">
<#else>
  <#assign tableConstraint=tablePart/><#include "/create/_tableConstraint.ftl">
</#if>
</@compress>
