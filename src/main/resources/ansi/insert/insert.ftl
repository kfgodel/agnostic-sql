<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
INSERT INTO ${model.tableName} (
<#list model.columnAssignments as columnAssignment>
${columnAssignment.columnName}<#sep>, </#sep>
</#list>
) VALUES (
<#list model.columnAssignments as columnAssignment>
<@renderAsModel model=columnAssignment.assignedValue /><#sep>, </#sep>
</#list>
)
</@compress>