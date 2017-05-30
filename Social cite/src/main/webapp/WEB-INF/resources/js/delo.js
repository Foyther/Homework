$(".js-programmatic-enable").on("click", function () {
    $(".js-example-disabled").prop("disabled", false);
    $(".js-example-disabled-multi").prop("disabled", false);
});

$(".js-programmatic-disable").on("click", function () {
    $(".js-example-disabled").prop("disabled", true);
    $(".js-example-disabled-multi").prop("disabled", true);
});