$(document).ready(function(){
	 $(".foo3").carouFredSel({
                items: 1,
                auto: true,
				  pagination  : ".foo3_pag",
			scroll : {
              items            : 1,
              duration        : 1500,
                }
              
            });
			 $(".foo4").carouFredSel({
                items: 1,
                auto: true,
				  pagination  : ".foo4_pag",
			scroll : {
              items            : 1,
              duration        : 1500,
                }
              
            });
			 $(".foo5").carouFredSel({
                items: 1,
                auto: true,
				  pagination  : ".foo5_pag",
			scroll : {
              items            : 1,
              duration        : 1500,
                },
				 prev : { 
			  button : "#foo2_prev",
			  key : "left"
		   },

			   next : { 
				  button : "#foo2_next",
				  key : "right"
			   }
              
            });
			 $(".foo6").carouFredSel({
                items: 1,
                auto: true,
				  pagination  : ".foo6_pag",
			scroll : {
              items            : 1,
              duration        : 1500,
                },
				 prev : { 
			  button : "#foo6_prev",
			  key : "left"
		   },

			   next : { 
				  button : "#foo6_next",
				  key : "right"
			   }
              
            });
	$(".menuicon").click(function(){
		$(".mobile-menu").toggle();
	});
	
	
});