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
    
    $(".noFilter a").click(function(e){
    	e.preventDefault();
    	$(".srchFilter-wrap").fadeToggle(300);
    });
    
    $("input[name=chkAll]").click(function(){
    	var chk = $(this).prop("checked");
    	for(var i=0; i<8; i++){
    		$("#facility"+i).prop("checked", chk);
    	}
    });

    $(".facility-list input[name=facility]").change(function(){
        if($(".facility-list input[name=facility]:checked").length==8) {
        	$("input[name=chkAll]").prop("checked", true);
         } else {
        	 $("input[name=chkAll]").prop("checked", false);
         }
    });
    
    $("input[name=chkTotal]").change(function(){
        if($("#srchPrice1, #srchPrice2").attr("disabled") != "disabled"){
        	$("#srchPrice1, #srchPrice2").attr("disabled", true);
        } else {
        	$("#srchPrice1, #srchPrice2").attr("disabled", false);
        }
    });
});