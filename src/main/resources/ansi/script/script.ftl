<#include "/macros/_renderAsModel.ftl"/>
<#list model.statements as statement><@renderAsModel model=statement/><#sep>;
</#list>