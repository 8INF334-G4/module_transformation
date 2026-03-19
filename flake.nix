{
  description = "Module de transformation";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
  };

  outputs = {self, nixpkgs}:
    let
      system = "x86_64-linux";
      pkgs = nixpkgs.legacyPackages.${system};
    in
    {
      packages.${system}.default = pkgs.maven.buildMavenPackage {
        pname = "result";
        version = "0.1.0";
        src = ./.;


        jdk = pkgs.jdk21;
        mvnHash = "sha256-0G1vq2xFRgYq5dxAuSJP3wKMSw1vP8aemUcSPMyS6AA=";

        installPhase = ''
          mkdir -p $out/share/java
          cp target/*.jar $out/share/java
        '';

      };

      devShells.${system}.default = pkgs.mkShell {
        buildInputs = [
          pkgs.jdk21
          pkgs.maven
        ];
        shellHook = ''
          export JAVA_HOME=${pkgs.jdk21}/lib/openjdk
          echo "Java 21 loaded"
          java -version
        '';
      };
    };

}
