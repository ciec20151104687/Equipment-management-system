<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>设备信息管理系统</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/echarts.js"></script>
        <script type="text/javascript">
        function pageup(){
        	var pagevalue = $("#pagevalue").val();
        	var req_data={};
        	req_data["pagevalue"]=pagevalue;
        	req_data["page"]="pageup";
        	fajax("EquipmentServlet",req_data,function(data){
    		})
    		self.location.reload();
        }
        function pagedown(){
        	var pagevalue = $("#pagevalue").val();
        	var req_data={};
        	req_data["pagevalue"]=pagevalue;
        	req_data["page"]="pagedown";
        	fajax("EquipmentServlet",req_data,function(data){
    		})
    		self.location.reload();
        }

			function showTime(){
   				nowtime=new Date();
    			year=nowtime.getFullYear();
    			month=nowtime.getMonth()+1;
    			date=nowtime.getDate();
    			document.getElementById("mytime").innerText=year+"/"+month+"/"+date+" "+nowtime.toLocaleTimeString();
			}
			setInterval("showTime()",1000);
			
        function delete_product(id){
        	var Id = id;
        		fajax("DeleteEquipmentServlet?id="+id,null,function(data){
        		})
        		self.location.reload();

        }
        function delete_place(id){
        	var Id = id;
        		fajax("DeletePlaceServlet?id="+id,null,function(data){
        		})
        		self.location.reload();

        }
        function type_change(id){
        	var type = $("#usertype"+id).val();
        	var req_data={};
        	req_data["id"]=id;
        	req_data["type"]=type;
        	fajax("UserTypeChangeServlet",req_data,function(data){
        		
        	})
        	//$("#char").load(location.href + " #char");
        	self.location.reload();
        }
			function Change(id){
				var ID = id;
				var EquipmentName = $("#CE_name"+ID).val();
	        	var EquipmentId = $("#CE_id"+ID).val();
	        	var EquipmentType = $("#CE_type"+ID).val();
	        	var option = $("#option2").val();
	        	//var userid = $("#user_id").val();
	        		var req_data={};
		        	req_data["id"]=ID;
		        	req_data["ce_name"]=EquipmentName;
		        	req_data["ce_id"]=EquipmentId;
		        	req_data["ce_type"]=EquipmentType;
		        	req_data["option"]=option;
	        		//req_data["user_id"]=userid;
		        	fajax("ChangeEquipmentServlet",req_data,function(data){
		        		
		        	})
		        	self.location.reload();
	        	
	        }
			function Changeplace(id){
				var ID = id;
				var user_id = $("#user_id").val();
				var place_id = $("#place_id"+ID).val();
	        	var campus = $("#campus"+ID).val();
	        	var building = $("#building"+ID).val();
				var house_id = $("#house_id"+ID).val();
 				var major = $("#major"+ID).val();
	        	var req_data={};
	        	req_data["user_id"]=user_id;
		       	req_data["place_id"]=place_id;
		       	req_data["campus"]=campus;
		       	req_data["building"]=building;
		       	req_data["house_id"]=house_id;
		       	req_data["major"]=major;
		        fajax("ChangePlaceServlet",req_data,function(data){
		       		
		       	})
		       	self.location.reload();
	        	
	        }
        function Add(){
        	var EquipmentName = $("#EquipmentName").val();
        	var EquipmentId = $("#EquipmentId").val();
        	var EquipmentType = $("#EquipmentType").val();
        	var option = $("#option").val();
        	var userid = $("#user_id").val();
        		var req_data={};
        		req_data["EquipmentName"]=EquipmentName;
        		req_data["EquipmentId"]=EquipmentId;
        		req_data["EquipmentType"]=EquipmentType;
        		req_data["option"]=option;
        		req_data["user_id"]=userid;
        		fajax("AddEquipmentServlet",req_data,function(data){
        		
        		})
        		self.location.reload();
        }
        function Addplace(){
			var user_id = $("#user_id").val();
			var place_id = $("#PLACE_id").val();
        	var campus = $("#CAMPUS").val();
        	var building = $("#BUILDING").val();
			var house_id = $("#HOUSE_ID").val();
			var major = $("#MAJOR").val();
        	var req_data={};
        	req_data["user_id"]=user_id;
	       	req_data["place_id"]=place_id;
	       	req_data["campus"]=campus;
	       	req_data["building"]=building;
	       	req_data["house_id"]=house_id;
	       	req_data["major"]=major;
	        fajax("AddPlaceServlet",req_data,function(data){
	       		
	       	})
	       	self.location.reload();
        }
        function OpenA(id){
        	$("#topA"+id).toggleClass(" glyphicon-triangle-right");
            $("#topA"+id).toggleClass(" glyphicon-triangle-bottom");
        }
            $(function() {
                $(".meun-item").click(function() {
                    $(".meun-item").removeClass("meun-item-active");
                    $(this).addClass("meun-item-active");
                    var itmeObj = $(".meun-item").find("img");
                    itmeObj.each(function() {
                        var items = $(this).attr("src");
                        items = items.replace("_grey.png", ".png");
                        items = items.replace(".png", "_grey.png")
                        $(this).attr("src", items);
                    });
                    var attrObj = $(this).find("img").attr("src");
                    ;
                    attrObj = attrObj.replace("_grey.png", ".png");
                    $(this).find("img").attr("src", attrObj);
                });
                /* $("#topAD").click(function(id) {
                    $("#topA"+id).toggleClass(" glyphicon-triangle-right");
                    $("#topA"+id).toggleClass(" glyphicon-triangle-bottom");
                });*/
                $("#topBD").click(function() {
                    $("#topB").toggleClass(" glyphicon-triangle-right");
                    $("#topB").toggleClass(" glyphicon-triangle-bottom");
                });
                $("#topCD").click(function() {
                    $("#topC").toggleClass(" glyphicon-triangle-right");
                    $("#topC").toggleClass(" glyphicon-triangle-bottom");
                });
                $(".toggle-btn").click(function() {
                    $("#leftMeun").toggleClass("show");
                    $("#rightContent").toggleClass("pd0px");
                })
            })
        </script>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css" />
        <link rel="stylesheet" type="text/css" href="css/slide.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
    </head>
<body>
        <div id="wrap">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><span>设备信息管理系统</span></p>
                </div>
                <div id="personInfor">
                <table>
                <tr>
               		<td>
                		<img width=70px height= 70px; src="${sessionScope.SESSIONUSER.user_head }">
               		</td>
               		<td>
               			<input type="hidden" value="${sessionScope.SESSIONUSER.user_id }" id="user_id">
                		<p style="margin-top: 20px;margin-left:10px"><span>${sessionScope.SESSIONUSER.user_name }</span></p>
                		<p style="margin-left:10px"><span>${sessionScope.SESSIONUSER.user_type }</span></p>
                	</td>
                </tr>
                </table>	
                	<input type="hidden" value="${sessionScope.SESSIONUSER.user_type }" id="USERTYPE"/>
                	
                    <p style="margin-left:10px" >
                    	<a href="#chan" aria-controls="chan" role="tab" data-toggle="tab">修改密码</a>
                        <a href="login.jsp">退出登录</a>
                    </p>
                </div>
                <div class="meun-title">账号管理</div>
                <div class="meun-item" href="#sour" aria-controls="sour" role="tab" data-toggle="tab"><img src="images/icon_source.png">资源管理</div>
                <div class="meun-item" href="#plae" aria-controls="plae" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">地址管理</div>
                <div class="meun-item meun-item-active" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">用户信息</div>
                <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div>
            </div>
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
            	<span id="mytime" style="float:right;margin-right:50px; "></span>
                <a class="toggle-btn" id="nimei">
                    <i class="glyphicon glyphicon-align-justify"></i>
                </a>
                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- 资源管理模块 -->
                    <div role="tabpanel" class="tab-pane" id="sour">
                        <div class="check-div form-inline">
                            <button class="btn btn-yellow btn-xs" style="margin-top:20px" data-toggle="modal" data-target="#addSource">添加资源</button>
                        </div>
                        <div class="data-div">
                            <div class="row tableHeader">
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	序号：
                                </div>
                            	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                  						设备名称：
                                </div>
                            	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	设备编号：
                                </div>
                            	<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	设备类型：
                                </div>
                            	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	设备位置：
                                </div>
                            	<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	所属院系：
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                  						设备负责人：
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	操作：
                                </div>
                            </div>
                            <c:forEach items="${list }" var="equipment">
                            <div class="tablebody"  id='delete${equipment.id}'>
								<div class="row" >
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	${equipment.id}
                                	</div>	
									<div aria-expanded="false" onclick="OpenA(${equipment.id})" id="topAD" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " type="button"  data-toggle="collapse" data-parent="#accordion" href='#collapseSystem${equipment.id}'  aria-controls="collapseOne">
										<span id='topA${equipment.id}' class="glyphicon  glyphicon-triangle-bottom  "></span><span>${equipment.equipment_name}</span>
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${equipment.equipment_id}
									</div>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
										${equipment.equipment_type}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${equipment.equipment_place}
									</div>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
										${equipment.major}
									</div>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
										${equipment.user_id}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                            <button class="btn btn-success btn-xs" data-toggle="modal" data-target='#changeSource${equipment.id}'>修改</button>
                                            
                                            <button class="btn btn-danger btn-xs" data-toggle="modal" data-target='#deleteSource${equipment.id}'>删除</button>
                                     </div>
								</div>
	<!-- **************************************************************************************************************** -->               
                        <!--修改资源弹出窗口-->
                        <div class="modal fade" id='changeSource${equipment.id}' role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">修改资源</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form class="form-horizontal">
                                                <div class="form-group ">
                                                    <label for="sName" class="col-xs-3 control-label">设备名称：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="" class="form-control input-sm duiqi" value="${equipment.equipment_name}" id='CE_name${equipment.id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sLink" class="col-xs-3 control-label">设备编号：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="" class="form-control input-sm duiqi" value="${equipment.equipment_id}" id='CE_id${equipment.id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">设备类型：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" value="${equipment.equipment_type}" id='CE_type${equipment.id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sKnot" class="col-xs-3 control-label">设备位置：</label>
                                                    <div class="col-xs-8">
                                                        <select class="form-control input-sm duiqi" id="option2">
                                                    		<c:forEach items="${placelist }" var="place">
																<option >${place.major}${place.campus}${place.building}${place.house_id}——${place.place_id}</option>
															</c:forEach>
														</select>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" onclick="Change(${equipment.id})">修 改</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                <!-- **************************************************************************************************************** -->
                		
                		
                		<!--弹出删除资源警告窗口-->
                        <div class="modal fade" id='deleteSource${equipment.id}' role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            确定要删除${equipment.id}？删除后不可恢复！
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <button type="button" class="btn btn-xs btn-danger" data-dismiss="modal" onclick="delete_product(${equipment.id})">删 除</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                		
                		
                		
                		   
                <!-- **************************************************************************************************************** --> 
								<div id='collapseSystem${equipment.id}' class="collapse in" aria-expanded="false" aria-haspopup="false" style="height:270px">
                                    <div class="row"  style="height:270px">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 levl2" style="height: 270px">
                                            <img src="${equipment.equipment_img} " style="width: 360px; height: 270px;">
                                        </div>
                                    </div>
                                </div>	
                            </div>
                            </c:forEach>
                        </div>
                        <!--页码块-->
                        <footer class="footer">
                            <ul class="pagination">
                                <li>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    页
                                </li>
                                <li class="gray">
                                    共20页
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-menu-left" onclick="pageup()">
                                    </i>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-menu-right"  onclick="pagedown()">
                                    </i>
                                </li>
                            </ul>
                        </footer>
                        <!--弹出窗口 添加资源-->
                        <div class="modal fade" id="addSource" role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">添加设备</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form class="form-horizontal">
                                                <div class="form-group ">
                                                    <label for="sName" class="col-xs-3 control-label">设备名称：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="email" class="form-control input-sm duiqi" id="EquipmentName" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sLink" class="col-xs-3 control-label">设备编号：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="" class="form-control input-sm duiqi" id="EquipmentId" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">设备类型：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" id="EquipmentType" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sKnot" class="col-xs-3 control-label">设备位置：</label>
                                                    <div class="col-xs-8">
                                                    	<select class="form-control input-sm duiqi" id="option">
                                                    		<c:forEach items="${placelist }" var="place">
																<option >${place.major}${place.campus}${place.building}${place.house_id}——${place.place_id}</option>
															</c:forEach>
														</select>
                                                    </div>
                                                   
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <p class="btn btn-xs btn-xs btn-green" onclick="Add();" data-dismiss="modal">添 加</p>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                        <!-- /.modal -->
                    </div>
                    
<!-- *************权限管理模块 ********************************************************************-->
                    <div role="tabpanel" class="tab-pane" id="char">

                        <div class="check-div">
                            
                        </div>
                        <div class="data-div" >
                            <div class="row tableHeader">
                                <div class="col-xs-1 ">
                                    编号：
                                </div>
                                <div class="col-xs-2">
                                    头像：
                                </div>
                                <div class="col-xs-2">
                                    用户名：
                                </div>
                                <div class="col-xs-2">
                                    真实姓名：
                                </div>
                                <div class="col-xs-3">
                                    用户类型：
                                </div>
                                <div class="col-xs-2">
                                    操作
                                </div>
                            </div>
                            
                            <div class="tablebody">
                            <c:forEach items="${userlist }" var="user">
                                <div class="row">
                                    <div class="col-xs-1 ">
                                        ${user.id}
                                    </div>
                                    <div class="col-xs-2">
                                    <img src="${user.user_head} " style="width: 70px; height: 70px; margin-top:2px">
                            </div>
                            <div class="col-xs-2">
                                ${user.user_id}
                            </div>
                            <div class="col-xs-2">
                                ${user.user_name}
                            </div>
                            <div class="col-xs-3" >
                                ${user.user_type}
                            </div>
                            <div class="col-xs-2">
                                <button class="btn btn-danger btn-xs" style="margin-top:20px" data-toggle="modal" data-target='#changeChar${user.id}'>${user.user_typechange}</button>
                            </div>
                            
                            
    <!--弹出修改权限警告窗口-->
                <div class="modal fade" id='changeChar${user.id}' role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    是否确定${user.user_typechange}？
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <input type="hidden" value="${user.user_type}" id='usertype${user.id }'/>
                                <button type="button" class="btn btn-xs btn-danger" onclick="type_change(${user.id })" data-dismiss="modal" >确定</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->
                
                
                
                        </div>
					</c:forEach>
                    </div>

                </div>
                <!--页码块-->
                <footer class="footer">
                    <ul class="pagination">
                        <li>
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                            </select>
                            页
                        </li>
                        <li class="gray">
                            共20页
                        </li>
                        <li>
                            <i class="glyphicon glyphicon-menu-left">
                            </i>
                        </li>
                        <li>
                            <i class="glyphicon glyphicon-menu-right">
                            </i>
                        </li>
                    </ul>
                </footer>
               
                

            </div>
            <!--用户管理模块-->
            <div role="tabpanel" class="tab-pane active" id="user">
                <div class="check-div form-inline">
               		
                    <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
						
                    </div>
                </div>
                <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                            用户名
                        </div>
                        <div class="col-xs-2">
                            真实姓名
                        </div>
                        <div class="col-xs-2">
       	     电话                 
                        </div>
                        <div class="col-xs-2">
     	     邮箱                 
                        </div>
                       
                        <div class="col-xs-2">
                            操作
                        </div>
                    </div>
                    <div class="tablebody">

                        <div class="row">
                            <div class="col-xs-2 ">
                               ${sessionScope.SESSIONUSER.user_id }
                            </div>
                            <div class="col-xs-2">
                              ${sessionScope.SESSIONUSER.user_name }
                            </div>
                            <div class="col-xs-2">
                                ${sessionScope.SESSIONUSER.user_phone}
                            </div>
                            <div class="col-xs-2">
                                ${sessionScope.SESSIONUSER.user_email }
                            </div>
                         
                            <div class="col-xs-2">
                                <button class="btn btn-success btn-xs" style="margin-top:20px" data-toggle="modal" data-target="#reviseUser" >修改</button>
                            </div>
                        </div>
    					 <c:forEach items="${echarlist }" var="echar" varStatus="status" >
    					 	<input type="hidden" value="${fn:length(echarlist)}" id="echar">
    					 	<input type="hidden" value="${echar.equipment_name }" id='echar_name${status.count}'>
    					 	<input type="hidden" value="${echar.count }" id='echar_count${status.count}'>
    					 </c:forEach>
    					
                        <div id="chartmain" class="row" style="width:850px; height: 550px; float:left"></div>
                        <div id="chartmain2" class="row" style="width:850px; height: 550px;float:left"></div>
                    </div>
                </div>

				
                <!--弹出修改用户窗口-->
                
                <div class="modal fade" id="reviseUser" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">修改用户</h4>
                            </div>
                            <form class="form-horizontal" method="post" action="UpdateUserServlet">
                            <div class="modal-body">
                                <div class="container-fluid">
                                    
                                       <div class="form-group "> 
                                          <label for="sKnot" class="col-xs-3 control-label">编号：</label>
                                            <div class="col-xs-8 ">
                                                <label for="sKnot" class="col-xs-3 control-label">${sessionScope.SESSIONUSER.id }</label> 
                                            </div>
                                        </div>
                                        <div class="form-group "> 
                                            <label for="sName" class="col-xs-3 control-label">用户名：</label>
                                            <div class="col-xs-8 ">
                                            	<input type="hidden" id="id" name="id" value="${sessionScope.SESSIONUSER.id }"/>
                                                <input type="" class="form-control input-sm duiqi" id="sName" name="userid" placeholder="" value="${sessionScope.SESSIONUSER.user_id }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sLink" class="col-xs-3 control-label" >真实姓名：</label>
                                            <div class="col-xs-8 ">
                                                <input type="" class="form-control input-sm duiqi" id="sLink"  name="name" placeholder="" value="${sessionScope.SESSIONUSER.user_name }">
                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sOrd" class="col-xs-3 control-label">电话：</label>
                                            <div class="col-xs-8">
                                                <input type="" class="form-control input-sm duiqi" id="sOrd" name="phone"  placeholder="" value="${sessionScope.SESSIONUSER.user_phone }">
                                              
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sKnot" class="col-xs-3 control-label">电子邮箱：</label>
                                            <div class="col-xs-8">
                                                <input type="" class="form-control input-sm duiqi" id="sKnot" name="email"  placeholder="" value="${sessionScope.SESSIONUSER.user_email }">
                                               
                                            </div>
                                        </div>
                                        <div class="form-group">
                                             <label for="sKnot" class="col-xs-4 control-label">用户类型：</label>
                                            <div class="col-xs-8">
                                               <label for="sKnot" class="col-xs-4 control-label" >${sessionScope.SESSIONUSER.user_type }</label> 
                                            </div>
                                        </div>
                                        
                                   
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green" onclick="alert('信息修改成功，请重新登陆');">保 存</button>
                            </div>
                            </form>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->
				
            </div>
            <!-- 修改密码模块 -->
            <div role="tabpanel" class="tab-pane" id="chan">
                <div class="check-div">
               
                </div>
                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    <form class="form-horizontal" action="ChangePwdServlet" method="post">
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">用户名：</label>
                            <div class="col-xs-5">
                            <input type="hidden" id="id" name="id" value="${sessionScope.SESSIONUSER.id }"/>
                               <label for="sKnot" class="col-xs-6 control-label" >${sessionScope.SESSIONUSER.user_name }</label> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">新密码：</label>
                            <div class="col-xs-5">
                                <input type="" class="form-control input-sm duiqi" id="sKnot" name= "pwd" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                           
                            
                        </div>
                        <div class="form-group text-right">
                            <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                <button type="reset" class="btn btn-xs btn-white">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green" onclick="alert('密码修改成功，请重新登陆！');">保存</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
            
        
            
            <!-- 地址管理模块 -->
                    <div role="tabpanel" class="tab-pane" id="plae">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" style="margin-top:20px" data-toggle="modal" data-target="#addplace">添加地址信息</button>
                        </div>
                        <div class="data-div">
                            <div class="row tableHeader">
                            	<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	位置Id：
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
                                    	校区：
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	教学楼：
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	门牌号：
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	所属院系：
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	负责人：
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                    	操作：
                                </div>
                            	
                            </div>
                            <c:forEach items="${placelist }" var="place">
                            <div class="tablebody" >
								<div class="row" >
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
										${place.place_id}
									</div>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
										${place.campus}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${place.building}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${place.house_id}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${place.major}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
										${place.user_id}
									</div>
									<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">
                                            <button class="btn btn-success btn-xs" data-toggle="modal" data-target='#changeSource2${place.place_id}'>修改</button>
                                            
                                            <button class="btn btn-danger btn-xs" data-toggle="modal" data-target='#deleteSource2${place.place_id}'>删除</button>
                                     </div>
								</div>
	<!-- **************************************************************************************************************** -->               
                        <!--修改资源弹出窗口-->
                        <div class="modal fade" id='changeSource2${place.place_id}' role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">修改地址信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form class="form-horizontal">
                                                <div class="form-group ">
                                                    <label for="sName" class="col-xs-3 control-label">位置ID：</label>
                                                    <div class="col-xs-8 ">
                                                        <input  type="text" readonly="readonly" class="form-control input-sm duiqi" value="${place.place_id}" id='place_id${place.place_id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sLink" class="col-xs-3 control-label">校区：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="" class="form-control input-sm duiqi" value="${place.campus}" id='campus${place.place_id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">教学楼：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" value="${place.building}" id='building${place.place_id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">门牌号：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" value="${place.house_id}" id='house_id${place.place_id}' placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">所属院系：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" value="${place.major}" id='major${place.place_id}' placeholder="">
                                                    </div>
                                                </div>
                                                
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" onclick="Changeplace(${place.place_id})">修 改</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                <!-- **************************************************************************************************************** -->
                		
                		
                		<!--弹出删除资源警告窗口-->
                        <div class="modal fade" id='deleteSource2${place.place_id}' role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            确定要删除${place.place_id}？删除后不可恢复！
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <button type="button" class="btn btn-xs btn-danger" data-dismiss="modal" onclick="delete_place(${place.place_id})">删 除</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                		
                		
                		
                		   
                <!-- **************************************************************************************************************** --> 
								
                            </div>
                            </c:forEach>
                        </div>
                        <!--页码块-->
                        <footer class="footer">
                            <ul class="pagination">
                                <li>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    页
                                </li>
                                <li class="gray">
                                    共20页
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-menu-left">
                                    </i>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-menu-right">
                                    </i>
                                </li>
                            </ul>
                        </footer>
                        <!--弹出窗口 添加资源-->
                        <div class="modal fade" id="addplace" role="dialog" aria-labelledby="gridSystemModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="gridSystemModalLabel">添加位置信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form class="form-horizontal">
                                                <div class="form-group ">
                                                    <label for="sName" class="col-xs-3 control-label">位置ID：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="email" class="form-control input-sm duiqi" id="PLACE_id" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sLink" class="col-xs-3 control-label">校区：</label>
                                                    <div class="col-xs-8 ">
                                                        <input type="" class="form-control input-sm duiqi" id="CAMPUS" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sOrd" class="col-xs-3 control-label">教学楼：</label>
                                                    <div class="col-xs-8">
                                                        <input type="" class="form-control input-sm duiqi" id="BUILDING" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sKnot" class="col-xs-3 control-label">门牌号：</label>
                                                    <div class="col-xs-8">
                                                    	<input type="" class="form-control input-sm duiqi" id="HOUSE_ID" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="sKnot" class="col-xs-3 control-label">所属学院：</label>
                                                    <div class="col-xs-8">
                                                    	<input type="" class="form-control input-sm duiqi" id="MAJOR" placeholder="">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-xs btn-xs btn-white" data-dismiss="modal">取 消</button>
                                        <p class="btn btn-xs btn-xs btn-green" onclick="Addplace();" data-dismiss="modal">添 加</p>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                        <!-- /.modal -->
                    </div>
        </div>
    </div>
</div>
<script src="js/jquery.nouislider.js"></script>
<script type="text/javascript">
      	//初始化echarts实例
        var myChart = echarts.init(document.getElementById('chartmain'));
        //指定图标的配置和数据
 	
		var en = [];
		var ec = [];
		var i = 0;
		var echar = $("#echar").val();
		for(i;i<echar;i++){
			en[i] = $("#echar_name"+(i+1)).val();
			ec[i] = $("#echar_count"+(i+1)).val();
		}    	
		
        var option = {
        	    color: ['#3398DB'],
        	    tooltip : {
        	        trigger: 'axis',
        	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
        	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        	        }
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : en,
        	            axisTick: {
        	                alignWithLabel: true
        	            }
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value'
        	        }
        	    ],
        	    series : [
        	        {
        	            name:'直接访问',
        	            type:'bar',
        	            barWidth: '60%',
        	            data:ec
        	        }
        	    ]
        	};

        //使用制定的配置项和数据显示图表
        myChart.setOption(option);
    </script>
    <script type="text/javascript">
      	//初始化echarts实例
        var myChart2 = echarts.init(document.getElementById('chartmain2'));
        //指定图标的配置和数据
 	
		var en = [];
		var ec = [];
		var data = [];
		var i = 0;
		var echar = $("#echar").val();
		for(i;i<echar;i++){
			en[i] = $("#echar_name"+(i+1)).val();
			ec[i] = $("#echar_count"+(i+1)).val();
			data[i]=[ec[i],en[i]];
		} 
		

        var option2 = {
        	    title : {
        	        text: '',
        	        subtext: '',
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        x : 'center',
        	        y : 'bottom',
        	        data:en
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {
        	                show: true,
        	                type: ['pie', 'funnel']
        	            },
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    series : [
        	        {
        	            name:'半径模式',
        	            type:'pie',
        	            radius : [20, 110],
        	            center : ['25%', '50%'],
        	            roseType : 'radius',
        	            label: {
        	                normal: {
        	                    show: false
        	                },
        	                emphasis: {
        	                    show: true
        	                }
        	            },
        	            lableLine: {
        	                normal: {
        	                    show: false
        	                },
        	                emphasis: {
        	                    show: true
        	                }
        	            },
        	            data:data
        	        },
        	        {
        	            name:'面积模式',
        	            type:'pie',
        	            radius : [50, 110],
        	            center : ['75%', '50%'],
        	            roseType : 'area',
        	            data:[
        	                {value:ec[0], name:en[0]},
        	                {value:ec[1], name:en[1]},
        	                {value:ec[2], name:en[2]},
        	                {value:ec[3], name:en[3]},
        	                {value:ec[4], name:en[4]},

        	            ]
        	        }
        	    ]
        	};


        //使用制定的配置项和数据显示图表
        myChart2.setOption(option2);
    </script>
</body>
</html>