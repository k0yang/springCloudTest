<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
</head>
<body>
<h2>Hello  ${name}!</h2>
cssPath:${webapp}/css
<hr>
jsPath:${webapp}/js
<hr>
${version}
<hr>
[#if name??]
    yhyhyh
[#else]
    test
[/#if]

<hr/>

myAreaName: ${myAreaName}
[@areaName areaId=1]
        myAreaName: ${myAreaName}
[/@areaName]

<hr/>

areaNameMethod: ${areaNameMethod("yang","hui","test")}

</body>
</html>
