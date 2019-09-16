param($action)

$base_image = "shadowcljs-base:11"

Switch ($action) {
  "ManageDeps" {
    docker run -it --rm -v "$($pwd):/usr/src/service" $base_image /bin/ash
  }
  "InstallDeps" {
    docker-compose -f docker-compose.builder.yml run --rm install
  }
  "Build" {
    docker-compose -f docker-compose.builder.yml run --rm build
  }
  "Run" {
    docker-compose up
  }
}