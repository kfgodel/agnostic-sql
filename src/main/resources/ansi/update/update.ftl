<#include "/macros/_renderAsModel.ftl">
<@compress single_line=true>
UPDATE <@renderAsModel model=model.table/>
SET <#list model.columnAssignments as columnAssignment>
  <@renderAsModel model=columnAssignment />
  <#sep>, </#sep>
</#list>
<#if model.whereClause.defined>
${" "}<@renderAsModel model=model.whereClause/>
</#if>
</@compress>