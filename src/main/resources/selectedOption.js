/**
 * Find selected option elements by model name.
 *
 * arguments[0] {Element} The scope of the search.
 * arguments[1] {string} The model name.
 *
 * @return {Array.WebElement} The matching select elements.
 */
var findSelectedOption = function(model, using) {
    var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\:'];
    for (var p = 0; p < prefixes.length; ++p) {
        var selector = '[' + prefixes[p] + 'model="' + model + '"] option:checked';        
        var elements = using.querySelectorAll(selector);
        if (elements.length) {
            return elements;
        }
    }
};
var using = arguments[0] || document;
var model = arguments[1];
return findSelectedOption(model, using);