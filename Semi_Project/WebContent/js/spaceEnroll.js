$(document).ready(function(){
    var x, i, j, selElmnt, a, b, c;

    x = document.getElementsByClassName("custom-select");

    for (i = 0; i < x.length; i++) {
    selElmnt = x[i].getElementsByTagName("select")[0];

    a = document.createElement("DIV");
    a.setAttribute("class", "select-selected");
    a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
    x[i].appendChild(a);
    
    b = document.createElement("DIV");
    b.setAttribute("class", "select-items select-hide");
    
    for (j = 1; j < selElmnt.length; j++) {
        c = document.createElement("DIV");
        c.innerHTML = selElmnt.options[j].innerHTML;
        c.addEventListener("click", function(e) {
            var y, i, k, s, h;
            s = this.parentNode.parentNode.getElementsByTagName("select")[0];
            h = this.parentNode.previousSibling;
            for (i = 0; i < s.length; i++) {
            if (s.options[i].innerHTML == this.innerHTML) {
                s.selectedIndex = i;
                h.innerHTML = this.innerHTML;
                y = this.parentNode.getElementsByClassName("same-as-selected");
                for (k = 0; k < y.length; k++) {
                y[k].removeAttribute("class");
                }
                this.setAttribute("class", "same-as-selected");
                break;
            }
            }
            h.click();
        });
        b.appendChild(c);
    }
    x[i].appendChild(b);
    a.addEventListener("click", function(e) {
        e.stopPropagation();
        closeAllSelect(this);
        this.nextSibling.classList.toggle("select-hide");
        this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
    var x, y, i, arrNo = [];
    x = document.getElementsByClassName("select-items");
    y = document.getElementsByClassName("select-selected");
    for (i = 0; i < y.length; i++) {
        if (elmnt == y[i]) {
        arrNo.push(i)
        } else {
        y[i].classList.remove("select-arrow-active");
        }
    }
    for (i = 0; i < x.length; i++) {
        if (arrNo.indexOf(i)) {
        x[i].classList.add("select-hide");
        }
    }
    }

    document.addEventListener("click", closeAllSelect);
    
    //$(".spaceEnrollEvent .custom-select, #spaceEnrollAlwaysEventDate").hide();
    //$("#spaceEnrollNotAlwaysEventDate1, #spaceEnrollNotAlwaysEventDate2, #spaceEnrollNotAlwaysEventDate3").hide();
    $("#spaceEnrollEvent").on('change', function(){
        if($(this).prop("checked")){
            $("input[name=spaceEnrollEventType]").prop("disabled", false);
            $("#spaceEnrollEventPrice").prop("disabled", false);
        } else {
            $("input[name=spaceEnrollEventType]").prop("checked", false);
            $("input[name=spaceEnrollEventType]").prop("disabled", true);
            $("#spaceEnrollEventPrice").prop("disabled", true);
        }
    });
    $("#spaceEnrollAlwaysEvent").on('change', function(){
        if($(this).prop("checked")){
            $(".spaceEnrollEvent .custom-select, #spaceEnrollAlwaysEventDate").show();
            $("#spaceEnrollAlwaysEventPrice").css("display", "inline-block");
        } else {
            $(".spaceEnrollEvent .custom-select, #spaceEnrollAlwaysEventDate").hide();
            $("#spaceEnrollAlwaysEventPrice").css("display", "none");
        }
    });
    $("#spaceEnrollNotAlwaysEvent").on('change', function(){
        if($(this).prop("checked")){
            $("#spaceEnrollNotAlwaysEventDate1, #spaceEnrollNotAlwaysEventDate2, #spaceEnrollNotAlwaysEventDate3").show();
            $("#spaceEnrollNotAlwaysEventPrice").css("display", "inline-block");
        } else {
            $("#spaceEnrollNotAlwaysEventDate1, #spaceEnrollNotAlwaysEventDate2, #spaceEnrollNotAlwaysEventDate3").hide();
            $("#spaceEnrollNotAlwaysEventPrice").css("display", "none");
        }
    });
    
    $("#dayOff7").on('change', function(){
        if($(this).prop("checked")){
            $("#spaceEnrollDayOffETC").prop("disabled", false);
        } else {
            $("#spaceEnrollDayOffETC").val('');
            $("#spaceEnrollDayOffETC").prop("disabled", true);
        }
    });
    
    /*이미지 업로드 미리보기*/
    var selFiles;
    $("#spaceEnrollFile").on('change', handleImgFileSelect);
    function handleImgFileSelect(e){
    	var files = e.target.files;
    	var filesArr = Array.prototype.slice.call(files);
    	console.log(filesArr);
    	filesArr.forEach(function(f){
    		if(!f.type.match("image.*")){
    			alert("이미지 확장자만 가능합니다.");
    			return false;
    		}
    		
    		if (files && files[0].size > (10*1024*1024)) {
                alert("파일 사이즈가 10mb 를 넘습니다.");
                input.value = null;
                return false;
            }
    		
    		selFiles=f;
    		var reader = new FileReader();
    		reader.onload=function(e){
    			if($("#enrollImg1 img").length){
    				console.log("이미지가 이미 존재.");
    				$("#enrollImg1 img").attr("src", e.target.result);
    			} else {
    				$("#enrollImg1").append("<img src='"+e.target.result+"' height='110'>");
    			}
    		}
    		reader.readAsDataURL(f);
    	});
    	
    }
    
    /*다중 이미지 업로드 미리보기*/
    var selFiles2 = [];
    $("#spaceEnrollFileMultiple").on('change', handleImgFileSelect2);
    function handleImgFileSelect2(e){
    	
    	var files = e.target.files;
    	var filesArr = Array.prototype.slice.call(files);
    	console.log(filesArr);
    	filesArr.forEach(function(f){
    		if(!f.type.match("image.*")){
    			alert("이미지 확장자만 가능합니다.");
    			return false;
    		}
    		
    		if (files && files[0].size > (10*1024*1024)) {
                alert("파일 사이즈가 10mb 를 넘습니다.");
                input.value = null;
                return false;
            }
    		
    		selFiles2.push(f);
    	});	
    	
    	console.log(selFiles2.length);
    	
    	if(selFiles2.length>3){
			alert('파일 업로드는 최대 3장만 가능합니다.');
			selFiles2=[];
			return false;
		}
    	
    	if($("#enrollImg2 img").length){
			console.log("이미지가 이미 존재.");
			if(selFiles2.length>3){
				alert('파일 업로드는 최대 3장만 가능합니다.');
				selFiles2=[];
				return false;
			}
		}
    	$("#enrollImg2").html("");
    	selFiles2.forEach(function(f){
    		var reader = new FileReader();
    		reader.onload=function(e){
    			$("#enrollImg2").append("<img src='"+e.target.result+"' height='110'>");
    		}
    		reader.readAsDataURL(f);
    	});
    }
    
//    var cntFile=0;
//    $(".multipleFile label").click(function(){
//    	cntFile++;
//    	if(cntFile>1){
//    		$(".multipleFile .filebox").append("<input type='file' name='spaceEnrollFileMultiple' id='spaceEnrollFileMultiple"+cntFile+"' class='upload-hidden'>");
//    		$(this).attr("for", "spaceEnrollFileMultiple"+cntFile);
//    	}
//    });
});