package br.com.gva.wisedelivery.dominio.dto.enderecodto;

import lombok.Data;

@Data
public class EnderecoDTO {
   private String cep;
   private String state;
   private String city;
   private String neighborhood;
   private String street;
   private LocationDTO location;

   /* @Data
   public class Location {
        private Coordinates coordinates;

        @Data
        public class Coordinates {
            private String longitude;
            private String latitude;
        }
   } */

}


/* "cep": "89010025",
"state": "SC",
"city": "Blumenau",
"neighborhood": "Centro",
"street": "Rua Doutor Luiz de Freitas Melro",
"service": "viacep",
"location": {
    "type": "Point",
    "coordinates": {
        "longitude": "-49.0629788",
        "latitude": "-26.9244749" */