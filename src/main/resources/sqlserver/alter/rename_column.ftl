<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
EXEC sp_RENAME '[<@renderAsModel model=model.table/>].[<@renderAsModel model=model.renamedColumn />]','${model.newName}','COLUMN'
</@compress>