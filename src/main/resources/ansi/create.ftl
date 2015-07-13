CREATE TABLE ${tableName} (
<#list columnDeclarations as columnDeclaration>
  <#include "_columnDeclaration.ftl">
  <#sep>, </#sep>
</#list>
<#list tableConstraints>
,
<#items as tableConstraint>
<#include "_tableConstraint.ftl" >
</#items>
</#list>
);

