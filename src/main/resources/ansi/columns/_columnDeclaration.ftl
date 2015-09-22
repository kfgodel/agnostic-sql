<@renderAsModel model=model.column /> <@renderAsModel model=model.columnType />
<#if model.nullity??>
${model.nullity}
</#if>
<#if model.defaultValue??>
DEFAULT <@renderAsModel model=model.defaultValue />
</#if>