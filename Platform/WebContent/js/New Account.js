bubbly({
    colorStart:'#147600',
    colorStop: '#147600',
    bubbles:400,
    blur:10,
    compose: 'source-over',
    bubbleFunc:() => `hsla(${20 + Math.random() * 50}, 100%, 50%, .3)`,
    angleFunc:() => Math.random() > 0.5 ? Math.PI : 2 * Math.PI,
    velocityFunc:() => 1 + Math.random() * 1,
    radiusFunc:() => Math.random() * 20
  });

  