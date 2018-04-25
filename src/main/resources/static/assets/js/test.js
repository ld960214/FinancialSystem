<script> 
	function checkInt(o){ 
		theV=isNaN(parseInt(o.value))?0:parseInt(o.value); 
		if(theV!=o.value){o.value=theV;} 
			txtTotal.value=txtAmount.value*txtPrice.value; 
	} 
	function checkP(o){ 
		theV=isNaN(parseFloat(o.value))?0:parseFloat(o.value); 
		theV=parseInt(theV*100)/100; 
		if(theV!=o.value){ 
			theV=(theV*100).toString(); 
			theV=theV.substring(0,theV.length-2)+"."+theV.substring(theV.length-2,theV.length) 
			o.value=theV; 
		} 
		txtTotal.value=txtAmount.value*txtPrice.value; 
	} 
	</script> 
	数量: 
	<input id=txtAmount value=0 onkeyup="checkInt(this);" onpaste="checkInt(this);" oncut="checkInt(this);" ondrop="checkInt(this);" onchange="checkInt(this);"> 
	单价: 
	<input id=txtPrice value=0 onkeyup="checkP(this);" onpaste="checkP(this);" oncut="checkP(this);" ondrop="checkP(this);" onchange="checkP(this);" style="border-right-width:0px;margin-right:0px;"> 
	<input style="border-left-width:0px;margin-left:-4px;width:18px" value="￥" readonly> 
	总价: 
	<input id=txtTotal value=0 style="border-right-width:0px;margin-right:0px;" readonly> 
	<input style="border-left-width:0px;margin-left:-4px;width:18px" value="￥" readonly>
