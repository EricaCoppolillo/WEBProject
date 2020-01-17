/**
 * 
 */

var setting = {
                roots: document.querySelector('.my-js-slider'),
                type: 'range',
                step: 1,
                //prezzo minimo e prezzo massimo dei prodotti presenti
                limits : {     minLimit: 0,      maxLimit: 1000   },
               }
 var slider = wRunner(setting);


function changePage(next, actualPage, totalPages) {
	var outcome = false;
	var sel = "#page"+actualPage;
	if(next === true){
		if(actualPage + 1 <= totalPages){
			$(sel).removeClass();
			$(sel).addClass("page-item");
			sel = "#page"+(actualPage+1);
			$(sel).addClass("active");
			outcome = true;
		}
	}
	else {
		if (actualPage - 1 >= 1){
			$(sel).removeClass();
			$(sel).addClass("page-item");
			sel = "#page"+(actualPage-1);
			$(sel).addClass("active");
			outcome = true;
		}
	}
	return outcome;
	
}
