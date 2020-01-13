<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> RENAME <@renderAsModel model=model.renamedColumn /> TO ${model.newName}
</@compress>