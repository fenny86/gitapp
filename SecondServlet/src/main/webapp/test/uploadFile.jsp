<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName()  
  + ":" + request.getServerPort() + path + "/";
%>
<body>
  <h1>文件上傳</h1>
  <form action="<%=basePath%>FileSvl" enctype = "multipart/form-data" method = "post">
    文件名:<input type="text" name="fname" id="fname">
    <input type="file" name="file" onchange="show(this)"><br>
  <input type="submit" value="上傳">
  ${msg}
  </form>
</body>
<script src="http://ajax.microsoft.com/ajax/jQuery/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
  function show(source){
    var arrs = $(source).val().splite('\\');
    var filename = arrs[arrs.length - 1];
    $(#fname).val(filename);
  }
</script>