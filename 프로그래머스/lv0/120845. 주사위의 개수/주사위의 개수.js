function solution(box, n) {
    
    const CanWidth = Math.floor(box[0]/n);
    const CanDepth = Math.floor(box[1]/n);
    const CanHeight = Math.floor(box[2]/n);
    
    return CanWidth*CanDepth*CanHeight;
    
    
}