<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Three.js GLTF Example</title>
    <link rel="stylesheet" href="/css/arCarModel.css">
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
        scene.background = new THREE.Color("#fff");

        //Camera
        const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 3000);
        camera.position.set(4, 1, 3)

        //render
        const renderer = new THREE.WebGLRenderer({antialias: true})
        renderer.setSize(window.innerWidth, window.innerHeight)
        container.appendChild(renderer.domElement)

        let plain;
        {
            plain = new THREE.Mesh(
                new THREE.PlaneGeometry(3, 5),
                new THREE.MeshBasicMaterial({color: "#FFFFFFFF"})
            )
            plain.receiveShadow = true;
            plain.position.set(0, -1, 0)
            plain.rotateX(-Math.PI / 2);
            scene.add(plain)
        }

        // Model
        {
            const loader = new THREE.GLTFLoader();
            loader.load('${car.getUrl3d()}', gltf => {
                    scene.add(gltf.scene);
                },
                function (error) {
                    console.log('Error: ' + error)
                }
            )
        }

        {
            const light = new THREE.DirectionalLight(0xffffff, 1)
            light.position.set(-2, 0, 10)
            light.lookAt(0, -1, 0)
            scene.add(light)

            // Helper
            // const helper = new THREE.DirectionalLightHelper(light, 5)
            // scene.add(helper)
        }

        {
            const light = new THREE.DirectionalLight(0xffffff, 1)
            light.position.set(-1, 0, 15)
            light.lookAt(0, -2, 0)
            scene.add(light)

            // Helper
            // const helper = new THREE.DirectionalLightHelper(light, 5)
            // scene.add(helper)
        }

        {
            const light = new THREE.DirectionalLight(0xffffff, 1)
            light.position.set(2, 0, 5)
            light.lookAt(0, 1, 0)
            scene.add(light)



            // Helper
            // const helper = new THREE.DirectionalLightHelper(light, 5)
            // scene.add(helper)
        }

        // Add Ambient Light
        const ambientLight = new THREE.AmbientLight(0xffffff, 0.5); // Color and intensity
        scene.add(ambientLight);

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
