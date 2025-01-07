package foro.hub.forohub.controller;

import foro.hub.forohub.domain.topico.DatosRegistroTopico;
import foro.hub.forohub.domain.topico.Topico;
import foro.hub.forohub.domain.topico.TopicoRepository;
import foro.hub.forohub.domain.usuario.Usuario;
import foro.hub.forohub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController
{
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){

        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroTopico.id_usuario());
       topicoRepository.save(new Topico(datosRegistroTopico, usuario));
    }
}
