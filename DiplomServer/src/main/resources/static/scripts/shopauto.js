document.addEventListener("DOMContentLoaded", function() {
    const buttons = document.querySelectorAll(".selectButton button");
    buttons.forEach(button => {
        button.addEventListener("click", function() {
            const id = this.id;
            const carBlocks = document.querySelectorAll(".info1");
            carBlocks.forEach(block => {
                const seriestype = block.getAttribute("data-seriestype");
                const series = block.getAttribute("data-series");
                if(id === "allModels"){
                    block.style.display = "block"
                }else if(id === "M" && seriestype ==="M"){
                    block.style.display = "block"
                } else if(seriestype === "stock" && id === series){
                    block.style.display = "block";
                }else{
                    block.style.display = "none";
                }
            });
        });
    });
});