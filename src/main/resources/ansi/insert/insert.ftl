<#include "/macros/_renderAsModel.ftl" />
<@compress single_line=true>
INSERT INTO <@renderAsModel model=model.table/> (
<#list model.columnAssignments as columnAssignment>
<@renderAsModel model=columnAssignment.column/><#sep>, </#sep>
</#list>
) VALUES (
<#list model.columnAssignments as columnAssignment>
<@renderAsModel model=columnAssignment.assignedValue /><#sep>, </#sep>
</#list>
)
</@compress>