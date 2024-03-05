<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/arCarModel.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <title>${car.getModel()} AR</title>
</head>
<body>

<div class="qrCont">
    <img src="${car.getQrUrl()}">
    <p>Сканируйте код и осмотрите автомобиль в дополненной реальности</p>
</div>
<div class="container"></div>
<div class="logoCont">
    <form action="/returnmain" target="">
        <button class="logo_heade_button">
        </button>
    </form>
    <#if car.getSeriestype() == "M">
        <p1>THE  ${car.getSeriestype()}${car.getSeries()} ${car.getModel()}</p1>
    <#else>
        <p1>THE  ${car.getModel()}</p1>
    </#if>
</div>

<script src="https://cdn.jsdelivr.net/npm/three@latest/build/three.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/three@latest/examples/js/loaders/GLTFLoader.js"></script>
<script src="https://cdn.jsdelivr.net/npm/three@latest/examples/js/lights/RectAreaLightUniformsLib.js"></script>
<script src="https://cdn.jsdelivr.net/npm/three@latest/examples/js/controls/OrbitControls.js"></script>

<script>
    function init() {
        let container = document.querySelector('.container');

        //Scene
        const scene = new THREE.Scene()
        scene.background = new THREE.Color("#161718");

        //Camera
        const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 1, 5000);
        camera.position.set(4, 1, 3)

        //render
        const renderer = new THREE.WebGLRenderer({antialias: true})
        renderer.setSize(window.innerWidth, window.innerHeight)
        container.appendChild(renderer.domElement)


        // Model
        {
            const loader = new THREE.GLTFLoader();
            loader.load('${car.getUrl3d()}', gltf => {
                    gltf.scene.traverse(function (child) {
                        if (child.isMesh) {
                            child.castShadow = true;
                            child.receiveShadow = true;
                        }
                    });
                    scene.add(gltf.scene);
                },
                function (error) {
                    console.log('Error: ' + error)
                }
            )
        }

        //OrbitControls
        const controls = new THREE.OrbitControls(camera, renderer.domElement);
        controls.autoRotate = true;
        controls.autoRotateSpeed = 1;
        controls.enableDamping = true;

        //Resize
        window.addEventListener('resize', onWindowResize, false)

        function onWindowResize() {
            camera.aspect = window.innerWidth / window.innerHeight;
            camera.updateProjectionMatrix();

            renderer.setSize(window.innerWidth, window.innerHeight)
        }

        // Animate
        function animate() {
            requestAnimationFrame(animate)
            controls.update();
            renderer.render(scene, camera)
        }
        animate()

    }

    init()
</script>
</body>
</html>
