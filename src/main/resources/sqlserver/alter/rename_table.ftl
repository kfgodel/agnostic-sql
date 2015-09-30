<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
EXEC sp_RENAME '<@renderAsModel model=model.table/>', '${model.newName}'
</@compress>