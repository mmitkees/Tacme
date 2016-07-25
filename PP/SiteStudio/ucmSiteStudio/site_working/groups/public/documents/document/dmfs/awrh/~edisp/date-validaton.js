//Default Site Studio Generated Validation Script (.js)
function Validate(strContent) {
    if (isValidDate(strContent)) {
        return true;
    }
    else {
        return "enter valid date with format DD-MM-YYYY";
    }
}

function isValidDate(subject){
  if (subject.match(/^\d{2}[\-]\d{2}[\-]\d{4}$/)){
    return true;
  }else{
    return false;
  }
}
