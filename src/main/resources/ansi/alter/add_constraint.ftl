<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> ADD <@renderAsModel model=model.constraintDeclaration/>
</@compress>