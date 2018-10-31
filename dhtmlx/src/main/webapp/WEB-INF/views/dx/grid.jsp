<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="${skyPath}/dhtmlx.css"/>
</head>
<script>
	var newRowId = [];
	var mData = [{id:'delete',text:'delete'},
				{id:'add',text:'Add Row'}];
	var dxGrid,dxMenu;
	
	function save(){
		var addRows = [];
		
		for(var i=0; i<newRowId.length; i++){
			if(dxGrid.getRowAttribute(newRowId[i],'st') == 'new'){
				addRows[addRows.length] = dxGrid.getRowData(newRowId[i]);
			}
		}
		var conf = {
				url : '/levelinfos',
				method : 'POST',
				param : JSON.stringify(addRows),
				success : function(res){
					alert(res + '개의 행 저장성공');
					newRowId = [];
				}
		}
		var au = new AjaxUtil(conf);
		au.send();
	}
	
	function doInit(){
		dxMenu = new dhtmlXMenuObject();
		dxMenu.setIconsPath('../common/images/');
		dxMenu.renderAsContextMenu();
		dxMenu.attachEvent('onClick',function(mId,type){
			console.log(mId);
			console.log(type);
			if(mId=='delete'){
				var rId = dxGrid.getSelectedRowId();
				var cIdx = dxGrid.getColIndexById('linum');
				var linum = dxGrid.cells(rId,cIdx).getValue();
				if(!rId){
					alert('삭제할 로우를 선택해주세요');
					return;
				}else if(rId){
					dhx.ajax.del('/levelinfos/' + linum);
					alert('삭제완료');
					initList();
					}
			}else if(mId=='add'){
				var conf = {
						url : '/linum',
						success : function(res){
							var res = JSON.parse(res);
							var rId = dxGrid.uid();
							newRowId[newRowId.length] = rId;
							dxGrid.addRow(rId,[res],dxGrid.getRowsNum());
							dxGrid.setRowAttribute(rId,'st','new');
						}
				}
				var au = new AjaxUtil(conf);
				au.send();
				/* dhx.ajax.get('/linum',function(res){
					var data = JSON.parse(res.xmlDoc.responseText);
					var rId = dxGrid.uid();
					dxGrid.addRow(rId,[data],dxGrid.getRowsNum());
					dxGrid.setRowAttribute(rId,'st','new');
				}); */
			}
		});
		dxMenu.loadStruct(mData);
		
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${skyPath}/imgs/');
		dxGrid.setHeader('번호,레벨,이름,설명');
		dxGrid.setColumnIds('linum,lilevel,liname,lidesc');
		dxGrid.setColTypes('ro,ed,ed,ed');
		dxGrid.enableContextMenu(dxMenu);
		dxGrid.init();
		
		dhx.ajax.get('/levelinfos',function(res){
			var data = JSON.parse(res.xmlDoc.responseText);
			dxGrid.parse(data,'js');
		});
		dxGrid.attachEvent('onEditCell',function(stage,rId,cInd,nValue,oValue){
			if(stage==2){				
				if(dxGrid.getRowAttribute(rId,'st')=='new'){
					return true;
				}
				if(nValue!=oValue){
					var rData = dxGrid.getRowData(rId);
					
					params = JSON.stringify(rData);
					var conf = {
							url : '/levelinfos/' + rData.linum,
							method : 'PUT',
							param : params,
							success : function(res){
								if(res=='1'){
									initList();
								}
							}
					}
					var au = new AjaxUtil(conf);
					au.send();
			
				}
			}
		});
	}
	
	function initList(){
		dhx.ajax.get('/levelinfos',function(res){
			var data = JSON.parse(res.xmlDoc.responseText);
			dxGrid.parse(data,'js');
		})
	}
	
	function makeParams(data){
		var params = '';
		for(var key in data){
			params += key + '=' + data[key] + '&';
		}
		return params.substring(0,params.length-1);
	}
	
	window.addEventListener('load',doInit);
</script>
<script src="/resources/js/AjaxUtil.js"></script>
<body>
	<div id="dxGrid" style="width:400px;height:300px;"></div>
	<button onclick="save()">저장</button>
</body>
</html>