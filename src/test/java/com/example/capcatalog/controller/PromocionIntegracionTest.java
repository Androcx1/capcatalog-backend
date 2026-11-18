package com.example.capcatalog.controller;

import com.example.capcatalog.entity.PromocionUsuario;
import com.example.capcatalog.repository.PromocionUsuarioRepository;
import com.example.capcatalog.service.PromocionUsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PromocionIntegracionTest {

    private MockMvc mockMvc;

    private PromocionUsuarioRepository repository;


    @BeforeEach
    void setUp() {

        repository =
                mock(PromocionUsuarioRepository.class);

        PromocionUsuarioService service =
                new PromocionUsuarioService(repository);

        PromocionUsuarioController controller =
                new PromocionUsuarioController(service);

        mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .build();


        when(
                repository.save(
                        any(PromocionUsuario.class)
                )
        ).thenAnswer(
                invocation ->
                        invocation.getArgument(0)
        );
    }


    /*
     * AUT-04
     * Controller -> Service -> Repository
     * Aceptación válida.
     */
    @Test
    void aceptarPromocionIntegraComponentesCorrectamente()
            throws Exception {

        mockMvc.perform(
                post(
                        "/api/mobile/promociones/aceptar"
                )
                .contentType(
                        MediaType.APPLICATION_JSON
                )
                .content("""
                        {
                          "idPromocion": "PROMO-AUT-01",
                          "producto": "Gorra automatizada",
                          "descripcion": "Prueba de integración",
                          "descuento": "10% OFF",
                          "precioAnterior": 500,
                          "precioOferta": 450,
                          "fechaCaducidad": "2026-12-20"
                        }
                        """)
        )
        .andExpect(
                status().isCreated()
        )
        .andExpect(
                jsonPath("$.decision")
                        .value("ACEPTADA")
        )
        .andExpect(
                jsonPath("$.estado")
                        .value("VIGENTE")
        );


        verify(
                repository,
                times(1)
        ).save(
                any(PromocionUsuario.class)
        );
    }


    /*
     * AUT-05
     * Controller -> Service -> Repository
     * Rechazo válido.
     */
    @Test
    void rechazarPromocionIntegraComponentesCorrectamente()
            throws Exception {

        mockMvc.perform(
                post(
                        "/api/mobile/promociones/rechazar"
                )
                .contentType(
                        MediaType.APPLICATION_JSON
                )
                .content("""
                        {
                          "idPromocion": "PROMO-AUT-02",
                          "producto": "Gorra automatizada",
                          "descripcion": "Prueba de integración",
                          "descuento": "15% OFF",
                          "precioAnterior": 600,
                          "precioOferta": 510,
                          "fechaCaducidad": "2026-12-20"
                        }
                        """)
        )
        .andExpect(
                status().isCreated()
        )
        .andExpect(
                jsonPath("$.decision")
                        .value("RECHAZADA")
        );


        verify(
                repository,
                times(1)
        ).save(
                any(PromocionUsuario.class)
        );
    }


    /*
     * AUT-06
     * JSON inválido.
     * Debe rechazarse antes de persistir.
     */
    @Test
    void jsonMalformadoNoLlegaAPersistencia()
            throws Exception {

        mockMvc.perform(
                post(
                        "/api/mobile/promociones/aceptar"
                )
                .contentType(
                        MediaType.APPLICATION_JSON
                )
                .content(
                        "{malformado}"
                )
        )
        .andExpect(
                status().isBadRequest()
        );


        verifyNoInteractions(
                repository
        );
    }
}