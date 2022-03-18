// position:absolute 不会受其他对象位置影响 relative 会受其他对象位置影响,对象不可层叠设置位置 使用
// left ， right ， top ， bottom 等属性相对于其最接近的一个最有定位设置的父对象进行绝对定位.
function header(name){
    var str = "<div class=\"w\">";
    str += "<ul class=\"fl lh\">";
    str += "	<li>";
    str += "		<span style=\"position: absolute;left: 350px;\">官方网站：";
    str += "			<a title=\"www.le_books.org\" href=\"index.action\">www.le_books.org</a>";
    str += "		</span>";
    str += "	</li>";
    str += "</ul>";
    str += "<ul class=\"fr lh\">";
    if (name == null || name == "" || name.length == 0){
        str += "	<li>";
        str += "		<span>";
        str += "			[<a href=\"adminLogin.action\">管理员登录</a>]";
        str += "		</span>";
        str += "	</li>";
    }else{
        str += "	<li>";
        str += "<span>管理员： ";
        str += "		<span style='color:red;'>" + name;
        str += "		</span>，您好!&nbsp;&nbsp;欢迎登陆后台管理系统！&nbsp;&nbsp;";
        str += "		</span>";
        str += "		[<a href=\"logout.action\">退出</a>]";
        str += "	</li>";
    }
    str += "	<li>&nbsp;[<a href=\"userInfo.action\">管理员中心</a>]</li>";
    str += "</ul>";
    str += "</div>";
    str += "</div>";
    //header bar
    str += "<div class=\"header\">";
    str += "<div class=\"top w960 center\">";
    str += "	<div class=\"toptitle\">";
    str += "	<h1>";
    str += "		<a style=\"logo_style\" title=\"le_books租赁平台\" href=\"index.action\"></a>";
    str += "		<a href=\"index.action\" title=\"le_books租赁平台\"><img height=\"80\" alt=\"le_books租赁平台\" src=\"static/images/logo.jpg\"></a>";
    str += "	</h1>";
    str += "</div>";
    str += "<div class=\"banner\">";

    str +="	<img height=\"65\" width=\"552\" alt=\"疯狂软件教育-购物商城\" border=\"0\" src=\"static/images/read.jpg\">";
    str += "</div>";
    str += "<div class=\"rlink\">";
    str += "	<ul>";
    str += "		<li class=\"r3\">";
    str += "			<a title=\"关于我们\" href=\"abort.action\">关于我们</a>";
    str += "		</li>";
    str += "		<li class=\"r4\">";
    str += "			<a title=\"联系方式\" href=\"javascript:void(0);\">联系方式</a>";
    str += "		</li>";
    str += "	</ul>";
    str += "</div>";
    str += "</div>";
    document.write(str);
};